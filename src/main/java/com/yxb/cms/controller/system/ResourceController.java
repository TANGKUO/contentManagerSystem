package com.yxb.cms.controller.system;

import com.yxb.cms.controller.BasicController;
import com.yxb.cms.domain.vo.Resource;
import com.yxb.cms.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 资源Controller
 *
 * @author yangxiaobing
 * @date 2017/7/6
 */
@Controller
@RequestMapping("res")
public class ResourceController extends BasicController {

    @Autowired
    private ResourceService resourceService;


    /**
     *跳转到资源列表页面
     * @return
     */
    @RequestMapping("/res_list")
    public String toResListPage() {
        return "system/res_list";
    }


    /**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_res_list")
    @ResponseBody
    public String ajaxResourceList(Resource resource){
        return resourceService.selectResourceResultPageList(resource);
    }

    /**
     * 选择图标
     * @return
     */
    @RequestMapping("/res_img")
    public String toResImgPage() {
        return "system/res_img";
    }
    /**
     * 资源添加页面
     * @return
     */
    @RequestMapping("/res_edit")
    public String toResEditPage() {
        return "system/res_edit";
    }

    @RequestMapping("/ajax_res_menu_top")
    @ResponseBody
    public String ajaxResMenuTop(){
        return resourceService.selectResMenuTop();
    }

    @RequestMapping("/ajax_res_menu_left")
    @ResponseBody
    public String ajaxResMenuLeft(Integer resParentid){
        return resourceService.selectResLevelListByParentid(resParentid);
    }




}
