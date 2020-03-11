package mud.actions;

public abstract class Action {

    private final String actionName;
    private final String actionKeyword;
    private final String actionDescription;

    private final String statisticAssociated;
    private final int statisticChange;

    public Action (String name, String keyword, String description, String stat, int bonus) {
        actionName = name;
        actionKeyword = keyword;
        actionDescription = description;

        statisticAssociated = stat;
        statisticChange = bonus;
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
