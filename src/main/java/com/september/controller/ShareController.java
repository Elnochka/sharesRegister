package com.september.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.september.model.HistoryShare;
import com.september.model.Share;
import com.september.service.HistoryShareService;
import com.september.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/shares")
public class ShareController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShareController.class);
    @Autowired
    private ShareService shareService;
    @Autowired
    private HistoryShareService historyShareService;

    @GetMapping(value = {"","/{page}"})
    @ResponseBody
    public ModelAndView listShare(@PathVariable(required = false, name = "page") String page, @RequestParam(required = false, name = "findEdrpou") String findEdrpou, @RequestParam(required = false, name = "findStatus") String findStatus, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("shareView");
        List<Share> listShare;
        PagedListHolder<Share> shareList = new PagedListHolder<>();
        if(page == null) {
            shareList = new PagedListHolder<Share>();
            listShare = shareService.queryElements();
            assert findEdrpou != null;
            if(((findEdrpou != null) && (findStatus == null)) || (findEdrpou != "") && (findStatus == "")) {
                listShare = filterEdrpouShare(listShare,findEdrpou);
                LOGGER.info(listShare.toString());
            }
            if(((findStatus != null) && (findEdrpou == null)) || (findStatus != "") && (findEdrpou == "")) {
                listShare = filterStatusShare(listShare,findStatus);
                LOGGER.info(listShare.toString());
            }
            shareList.setSource(listShare);
            shareList.setPageSize(10);
            request.getSession().setAttribute("shareList", shareList);
        }else if(page.equals("prev")) {
            shareList = (PagedListHolder<Share>)request.getSession().getAttribute("shareList");
            shareList.previousPage();
        }else if(page.equals("next")) {
            shareList = (PagedListHolder<Share>)request.getSession().getAttribute("shareList");
            shareList.nextPage();
        }else {
            int pageNum = Integer.parseInt(page);
            shareList = (PagedListHolder<Share>)request.getSession().getAttribute("shareList");
            shareList.setPage(pageNum - 1);
        }
        modelAndView.addObject("shareList", shareList);
        return modelAndView;
    }

    private List<Share> filterEdrpouShare(List<Share> shareList, String findFilter){
        Share shares = shareList.stream().filter(p -> p.getEdrpou().equals(Long.parseLong(findFilter))).findFirst().get();
        List<Share> listShare = new ArrayList<>();
        listShare.add(shares);
        return listShare;
    }

    private List<Share> filterStatusShare(List<Share> shareList, String findFilter){
        List<Share> shares = shareList.stream().filter((p -> p.getStatus().equals(findFilter))).collect(Collectors.toList());
        return shares;
    }

    @GetMapping(value = "/createShare")
    public ModelAndView addShare(){
        ModelAndView modelAndView = new ModelAndView("shareCreateView");
        Share share = new Share();
        modelAndView.addObject("shareForm", share);
        return modelAndView;
    }

    @GetMapping(value = "/loadJson")
    public ModelAndView addShareJson(){
        loadJsonFile();
        return new ModelAndView("redirect:/");
    }

    public void loadJsonFile(){
        try (JsonParser jParser = new JsonFactory()
                .createParser(new File("d:\\listshares2.json"));) {

            if (jParser.nextToken() == JsonToken.START_ARRAY) {

                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    String comment = "";
                    Long edrpou = 0L;
                    int quantity = 0;
                    double value = 0.0;
                    double commonValue = 0.0;
                    String dateShare = "2020-09-04";
                    String status = "active";

                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        String fieldname = jParser.getCurrentName();
                        if ("comment".equals(fieldname)) {
                            jParser.nextToken();
                            comment = jParser.getText();
                            LOGGER.info(jParser.getText());
                        }

                        if ("edrpou".equals(fieldname)) {
                            jParser.nextToken();
                            edrpou = jParser.getLongValue();
                            LOGGER.info("" + jParser.getLongValue());
                        }

                        if ("quantity".equals(fieldname)) {
                            jParser.nextToken();
                            quantity = jParser.getIntValue();
                            LOGGER.info("" + jParser.getIntValue());
                        }

                        if ("commonValue".equals(fieldname)) {
                            jParser.nextToken();
                            commonValue = jParser.getDoubleValue();
                            LOGGER.info("" + jParser.getDoubleValue());
                        }

                        if ("value".equals(fieldname)) {
                            jParser.nextToken();
                            value = jParser.getDoubleValue();
                            LOGGER.info("" + jParser.getDoubleValue());
                        }

                        if ("dateShare".equals(fieldname)) {
                            jParser.nextToken();
                            dateShare = jParser.getText();
                            LOGGER.info(jParser.getText());
                        }

                        if ("status".equals(fieldname)) {
                            jParser.nextToken();
                            status = jParser.getText();
                            LOGGER.info(jParser.getText());
                        }


                    }
                    Share share = new Share(comment,edrpou,quantity,commonValue,value,dateShare,"active");
                    shareService.insertElement(share);

                }
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = "/createShare")
    public ModelAndView save(@Valid @ModelAttribute("shareForm") Share share, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("shareCreateView");
        }
        model.addAttribute("shareName", share.getEdrpou());
        shareService.insertElement(share);
        return new ModelAndView("redirect:/shares");
    }

    @GetMapping(value = "/editShare")
    @ResponseBody
    public ModelAndView find(@RequestParam String idShare){
        ModelAndView modelAndView = new ModelAndView("shareEditView");
        Share share = shareService.findElementId(Integer.parseInt(idShare));

        modelAndView.addObject("shareForm", share);
        return modelAndView;
    }

    @PostMapping(value = "/editShare")
    public ModelAndView update(@ModelAttribute("shareForm") Share share, BindingResult result, ModelMap model){

        if (result.hasErrors()) {
            return new ModelAndView("shareEditView");
        }
        LOGGER.info(share.getComment() + ";"+share.getDateShare()+";"+share.getEdrpou()+";"+share.getStatus());
        Share shareOld = shareService.findElementEDRPOU(share.getEdrpou());
        Map<String,String> mapOldFields = getFields(shareOld);
        shareService.updateElement(share);
        Map<String,String> mapNewFields = getFields(share);
        Map<String,String> mapChanges = compareFields(mapOldFields, mapNewFields);
        getDataForHistory(mapChanges, mapNewFields, share);
        return new ModelAndView("redirect:/shares");
    }

    private Map<String,String> getFields(Share share){
        Map<String,String> mapFields = new HashMap<>();
        mapFields.put("comment",share.getComment());
        mapFields.put("quantity",share.getQuantity().toString());
        mapFields.put("commonValue",share.getCommonValue().toString());
        mapFields.put("value",share.getValue().toString());
        mapFields.put("dateShare",share.getDateShare());
        mapFields.put("status",share.getStatus());
        return mapFields;
    }

    private void getDataForHistory(Map<String,String> mapChanges, Map<String,String> mapNewFields, Share share){
        for(Map.Entry<String,String> field: mapChanges.entrySet()){
            String fieldName = field.getKey();
            String oldField = field.getValue();
            String newField = mapNewFields.get(fieldName);
            HistoryShare historyShare = new HistoryShare(share.getEdrpou(),fieldName,oldField, newField);
            historyShareService.insertElement(historyShare);
        }
    }

    private Map<String,String> compareFields(Map<String,String> mapOldFields, Map<String,String> mapNewFields){
        Map<String,String> mapForLoad = new HashMap<>();
        if(mapOldFields.equals(mapNewFields)){
            LOGGER.info("equals");
        }
        if(!mapOldFields.get("comment").equals(mapNewFields.get("comment"))){
            mapForLoad.put("comment",mapOldFields.get("comment"));
            LOGGER.info(mapOldFields.get("comment"));
        }
        if(!mapOldFields.get("quantity").equals(mapNewFields.get("quantity"))){
            mapForLoad.put("quantity",mapOldFields.get("quantity"));
            LOGGER.info(mapOldFields.get("quantity"));
        }
        if(!mapOldFields.get("commonValue").equals(mapNewFields.get("commonValue"))){
            mapForLoad.put("commonValue",mapOldFields.get("commonValue"));
            LOGGER.info(mapOldFields.get("commonValue"));
        }
        if(!mapOldFields.get("value").equals(mapNewFields.get("value"))){
            mapForLoad.put("value",mapOldFields.get("value"));
            LOGGER.info(mapOldFields.get("value"));
        }
        if(!mapOldFields.get("dateShare").equals(mapNewFields.get("dateShare"))){
            mapForLoad.put("dateShare",mapOldFields.get("dateShare"));
            LOGGER.info(mapOldFields.get("dateShare"));
        }
        if(!mapOldFields.get("status").equals(mapNewFields.get("status"))){
            mapForLoad.put("status",mapOldFields.get("status"));
            LOGGER.info(mapOldFields.get("status"));
        }

        return mapForLoad;
    }

    @GetMapping(value = "/deleteShare")
    @ResponseBody
    public ModelAndView delete(@RequestParam String idShare){
        Share shareOld = shareService.findElementId(Integer.parseInt(idShare));
        Map<String,String> mapOldFields = getFields(shareOld);
        shareService.deleteElement(Integer.parseInt(idShare));
        Share share = shareService.findElementId(Integer.parseInt(idShare));
        Map<String,String> mapNewFields = getFields(share);
        Map<String,String> mapChanges = compareFields(mapOldFields, mapNewFields);
        getDataForHistory(mapChanges, mapNewFields, share);
        return new ModelAndView("redirect:/shares");
    }



}
