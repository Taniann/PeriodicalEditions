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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultPage that = (ResultPage) o;

        if (!page.equals(that.page)) return false;
        return routingType.equals(that.routingType);

    }

    @Override
    public int hashCode() {
        int result = page.hashCode();
        result = 31 * result + routingType.hashCode();
        return result;
    }
}
