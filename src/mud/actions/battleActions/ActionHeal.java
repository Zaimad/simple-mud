package mud.actions.battleActions;

public class ActionHeal extends BattleAction {
    public ActionHeal() {
        super("Heal",
                "heal",
                "Heal a target. It's not too specific; you wonder if it's effective at all if you just use your slobber instead.",
                "wisdom",
                1);
    }
}
