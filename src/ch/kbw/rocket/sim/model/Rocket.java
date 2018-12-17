package ch.kbw.rocket.sim.model;

import java.util.HashMap;

public class Rocket {

    private double mass;            //in kg
    private double massLossRate;    //in kg/s
    private double fuel;            //in kg
    private double height;          //in m
    private double velocity;        //in m/s
    private double acceleration;    // ?
    private double force;           //in N
    private double resultingForce;  //in N
    private double gravity;     //in N
    //TODO: Convert to Lists
    private HashMap<Long, Double> massHistory = new HashMap<>();
    private HashMap<Long, Double> heightHistory = new HashMap<>();
    private HashMap<Long, Double> velocityHistory = new HashMap<>();
    private HashMap<Long, Double> resultingForceHistory = new HashMap<>();
    private HashMap<Long, Double> gravityHistory = new HashMap<>();

    public Rocket(double mass, double massLossRate, double fuel, double force) {
        this.mass = mass;
        this.massLossRate = massLossRate;
        this.fuel = fuel;
        this.force = force;
        height = 0;
        acceleration = 0;
        resultingForce =0;
        gravity =0;
        velocity = 0;
    }

    public Rocket(Rocket rocket) {
        this.mass = rocket.getMass();
        this.massLossRate = rocket.getMassLossRate();
        this.fuel = rocket.getFuel();
        this.height = rocket.getHeight();
        this.velocity = rocket.getVelocity();
        this.acceleration = rocket.getAcceleration();
        this.force = rocket.getForce();
        this.resultingForce = rocket.getResultingForce();
        this.gravity = rocket.getGravity();
    }

    public void saveStep(long passedTime) {
        massHistory.put(passedTime, mass);
        heightHistory.put(passedTime, height);
        velocityHistory.put(passedTime, velocity);
        resultingForceHistory.put(passedTime, resultingForce);
        gravityHistory.put(passedTime, gravity);
    }

    public double getResultingForce() {
        return resultingForce;
    }

    public void setResultingForce(double resultingForce) {
        this.resultingForce = resultingForce;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getMassLossRate() {
        return massLossRate;
    }

    public void setMassLossRate(double massLossRate) {
        this.massLossRate = massLossRate;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public HashMap<Long, Double> getMassHistory() {
        return massHistory;
    }

    public HashMap<Long, Double> getHeightHistory() {
        return heightHistory;
    }

    public HashMap<Long, Double> getVelocityHistory() {
        return velocityHistory;
    }

    public HashMap<Long, Double> getResultingForceHistory() {
        return resultingForceHistory;
    }

    public HashMap<Long, Double> getGravityHistory() {
        return gravityHistory;
    }

}
