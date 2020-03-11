package mud.actions.battleActions;

import mud.actions.Action;

public abstract class BattleAction extends Action {

    String target;

    public BattleAction(String name, String keyword, String description, String stat, int bonus) {
        super(name, keyword, description, stat, bonus);
        target = "";
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

}
