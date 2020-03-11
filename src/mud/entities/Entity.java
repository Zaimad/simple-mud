package mud.entities;

import mud.actions.Action;
import mud.entities.neutral.ProtoEntity;

import java.util.Map;

public abstract class Entity {

    private String identifier;
    private String name;
    private int healthPointsMax;
    private int healthPoints;
    private int energyPointsMax;
    private int energyPoints;
    private double experiencePoints;

    private int attributeStrength;
    private int attributeIntelligence;
    private int attributeDexterity;
    private int attributeBravery;
    private int attributeWisdom;
    private int attributeSpeed;

    Map<String, Action> knownActions;

    public Entity() {

    }

    public Entity(String identifier) {
        this.identifier = identifier;
        healthPoints = healthPointsMax = 1;
        energyPoints = energyPointsMax = 1;
        experiencePoints = 0;

        //All stats set to 1
        attributeStrength = attributeIntelligence = attributeDexterity = attributeBravery = attributeWisdom = attributeSpeed = 1;


    }

    public String getIdentifier() {
        return identifier;
    }

    /*public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPointsMax() {
        return healthPointsMax;
    }

    public void setHealthPointsMax(int healthPointsMax) {
        this.healthPointsMax = healthPointsMax;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEnergyPointsMax() {
        return energyPointsMax;
    }

    public void setEnergyPointsMax(int energyPointsMax) {
        this.energyPointsMax = energyPointsMax;
    }

    public int getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public double getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(double experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getAttributeStrength() {
        return attributeStrength;
    }

    public void setAttributeStrength(int attributeStrength) {
        this.attributeStrength = attributeStrength;
    }

    public int getAttributeIntelligence() {
        return attributeIntelligence;
    }

    public void setAttributeIntelligence(int attributeIntelligence) {
        this.attributeIntelligence = attributeIntelligence;
    }

    public int getAttributeDexterity() {
        return attributeDexterity;
    }

    public void setAttributeDexterity(int attributeDexterity) {
        this.attributeDexterity = attributeDexterity;
    }

    public int getAttributeBravery() {
        return attributeBravery;
    }

    public void setAttributeBravery(int attributeBravery) {
        this.attributeBravery = attributeBravery;
    }

    public int getAttributeWisdom() {
        return attributeWisdom;
    }

    public void setAttributeWisdom(int attributeWisdom) {
        this.attributeWisdom = attributeWisdom;
    }

    public int getAttributeSpeed() {
        return attributeSpeed;
    }

    public void setAttributeSpeed(int attributeSpeed) {
        this.attributeSpeed = attributeSpeed;
    }

    public Map<String, Action> getKnownActions() {
        return knownActions;
    }

    public void setKnownActions(Map<String, Action> knownActions) {
        this.knownActions = knownActions;
    }

    public class EntityBuilder {

        Entity construct;

        public EntityBuilder(String identifier, String className) {
            switch (className) {
                default:
                    construct = new ProtoEntity(identifier);
            }
            //construct.setIdentifier(identifier);
            //construct = new Entity(identifier);
        }

        public Entity build() {
            return construct;
        }

    }

}
