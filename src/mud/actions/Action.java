package mud.actions;

public class Action {

    private final String actionName;
    private final String actionKeyword;
    private final String actionDescription;

    public Action (String name, String keyword, String description) {
        actionName = name;
        actionKeyword = keyword;
        actionDescription = description;
    }

    public String getActionName() {
        return actionName;
    }

    public String getActionKeyword() {
        return actionKeyword;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    @Override
    public String toString() {
        return "Identifying "+getActionName()+ ": \n" +
                "Keyword: "+getActionKeyword()+"\n"+
                getActionDescription();
    }

}
