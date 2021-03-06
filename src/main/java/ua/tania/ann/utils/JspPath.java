package ua.tania.ann.utils;

/**
 * Created by Таня on 24.08.2018.
 */
public final class JspPath {
    public static final String WELCOME_PAGE = "/welcome.jsp";
    public static final String LOGIN_PAGE = "/view/login.jsp";
    public static final String REGISTER_PAGE = "/view/register.jsp";
    public static final String CATALOG_PAGE = "/view/user/catalog.jsp";
    public static final String CATALOG_PAGE_FILTERED_BY_CATEGORY = "/view/user/catalogFilteredByCategory.jsp";
    public static final String CATALOG_PAGE_FILTERED_BY_TYPE = "/view/user/catalogFilteredByType.jsp";
    public static final String CART_PAGE = "/view/user/cart.jsp";
    public static final String ADD_TO_CART_PAGE = "/view/user/addToCart.jsp";
    public static final String PAYMENT_PAGE = "/view/user/payment.jsp";
    public static final String ORDER_PAGE = "/view/user/order.jsp";
    public static final String SUBSCRIPTIONS_PAGE = "/view/user/mySubscriptions.jsp";
    public static final String PROFILE_PAGE = "/view/user/profile.jsp";
    public static final String CHANGE_PASSWORD_PAGE = "/view/user/changePassword.jsp";
    public static final String CHANGE_EDITION_PAGE = "/view/admin/changeEdition.jsp";
    public static final String ADD_EDITION_CATEGORIES_PAGE = "/view/admin/addEditionCategories.jsp";
    public static final String ADMIN_PAGE = "/view/admin/adminPage.jsp";
    public static final String EDITION_ADD_PAGE = "/view/admin/addEdition.jsp";
    public static final String CATEGORY_ADD_PAGE = "/view/admin/addCategory.jsp";
    public static final String ERROR_PAGE = "/view/error.jsp";

    public static final String CATALOG_PAGE_COMMAND = "/controller?command=showCatalogPage&currentPage=1";
    public static final String ADMIN_PAGE_COMMAND = "/controller?command=showAdminPage&currentPage=1";
    public static final String CATEGORY_PAGE_COMMAND = "/controller?command=showAddCategory";
    public static final String CART_PAGE_COMMAND = "/controller?command=cart";
    public static final String PROFILE_PAGE_COMMAND = "/controller?command=profile";


    private JspPath() {
    }
}
