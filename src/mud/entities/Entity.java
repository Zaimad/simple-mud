package mud.entities;

public class Entity {

    private String identifier;
    private int healthPoints;
    private int energyPoints;
    private double experiencePoints;

    private int attributeStrength;
    private int attributeIntelligence;
    private int attributeDexterity;
    private int attributeBravery;
    private int attributeWisdom;
    private int attributeSpeed;

    public Entity(String identifier) {
        this.identifier = identifier;
        healthPoints = 1;
        energyPoints = 1;
        energyPoints = 0;

        //All stats set to 1
        attributeStrength = attributeIntelligence = attributeDexterity = attributeBravery = attributeWisdom = attributeSpeed = 1;


    }


}
