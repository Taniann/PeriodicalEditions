package ua.tania.ann.controller.command;

/**
 * Created by Таня on 24.08.2018.
 */
public class ResultPage {
    private String page;
    private RoutingType routingType;

    public ResultPage() {
    }

    public ResultPage(RoutingType routingType) {
        this.routingType = routingType;
    }


    public ResultPage(RoutingType routingType, String page) {
        this.routingType = routingType;
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public RoutingType getRoutingType() {
        return routingType;
    }

    public enum RoutingType {
        FORWARD, REDIRECT
    }

}
