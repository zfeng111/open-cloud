package com.github.lyd.rbac.client.api;

import com.github.lyd.common.model.PageList;
import com.github.lyd.common.model.ResultBody;
import com.github.lyd.rbac.client.entity.ResourceMenu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MenuRemoteService {
    /**
     * 获取菜单资源列表
     *
     * @return
     */
    @PostMapping("/menus")
    ResultBody<PageList<ResourceMenu>> menus(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "keyword", required = false) String keyword
    );

    /**
     * 获取菜单资源列表
     *
     * @return
     */
    @PostMapping("/menus/all")
    ResultBody<PageList<ResourceMenu>> menusAll(
            @RequestParam(name = "keyword", required = false) String keyword
    );

    /**
     * 获取菜单资源
     *
     * @param menuId menuId
     * @return 应用信息
     */
    @GetMapping("/menus/{menuId}")
    ResultBody<ResourceMenu> getMenu(@PathVariable("menuId") Long menuId);

    /**
     * 添加菜单资源
     *
     * @param menuCode    菜单编码
     * @param menuName    菜单名称
     * @param icon        图标
     * @param url         请求路径
     * @param enabled     是否启用
     * @param parentId    父节点ID
     * @param priority    优先级越小越靠前
     * @param description 描述
     * @return
     */
    @PostMapping("/menus/add")
    ResultBody<Boolean> addMenu(
            @RequestParam(value = "menuCode") String menuCode,
            @RequestParam(value = "menuName") String menuName,
            @RequestParam(value = "icon") String icon,
            @RequestParam(value = "url", required = false, defaultValue = "") String url,
            @RequestParam(value = "enabled", defaultValue = "true") Boolean enabled,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") Long parentId,
            @RequestParam(value = "priority", required = false, defaultValue = "0") Integer priority,
            @RequestParam(value = "description", required = false, defaultValue = "") String description
    );

    /**
     * 编辑菜单资源
     *
     * @param menuId      菜单ID
     * @param menuCode    菜单编码
     * @param menuName    菜单名称
     * @param icon        图标
     * @param url         请求路径
     * @param enabled     是否启用
     * @param parentId    父节点ID
     * @param priority    优先级越小越靠前
     * @param description 描述
     * @return
     */
    @PostMapping("/menus/update")
    ResultBody<Boolean> updateMenu(
            @RequestParam("menuId") Long menuId,
            @RequestParam(value = "menuCode") String menuCode,
            @RequestParam(value = "menuName") String menuName,
            @RequestParam(value = "icon") String icon,
            @RequestParam(value = "url", required = false, defaultValue = "") String url,
            @RequestParam(value = "enabled", defaultValue = "true") Boolean enabled,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") Long parentId,
            @RequestParam(value = "priority", required = false, defaultValue = "0") Integer priority,
            @RequestParam(value = "description", required = false, defaultValue = "") String description
    );

    /**
     * 禁用菜单资源
     *
     * @param menuId 菜单ID
     * @return
     */
    @PostMapping("/menus/disable")
    ResultBody<Boolean> disableMenu(
            @RequestParam("menuId") Long menuId
    );

    /**
     * 启用菜单资源
     *
     * @param menuId 菜单ID
     * @return
     */
    @PostMapping("/menus/enable")
    ResultBody<Boolean> enableMenu(
            @RequestParam("menuId") Long menuId
    );

    /**
     * 移除菜单
     *
     * @param menuId 菜单ID
     * @return
     */
    @PostMapping("/menus/remove")
    ResultBody<Boolean> removeMenu(
            @RequestParam("menuId") Long menuId
    );
}