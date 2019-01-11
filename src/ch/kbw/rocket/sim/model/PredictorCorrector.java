package ch.kbw.rocket.sim.model;

public class PredictorCorrector extends Algorithm {

    public PredictorCorrector(Rocket rocket, int interval) {
        super(rocket, interval);
        passedTime = 0;
    }

    private void init() {
        calculateGravitation();
        calculateResultingForce();
        rocket.setVelocity(getNewVelocity(interval, rocket.getVelocity()));
    }

    @Override
    public void run() {
        init();
        startTime = System.currentTimeMillis();

        while (running) {
            increment();
        }

        stopTime = System.currentTimeMillis();
        logPerformance();
    }

    @Override
    public void increment() {
        if (!stalling()) {
            //calculate gravitational force
            calculateGravitation();

            //calculate resulting force
            calculateResultingForce();

            calculatePrediction();
            //calculates new height
            rocket.setHeight(getNewHeight(interval, rocket.getHeight(), rocket.getVelocity()));

            //calculate fuel loss
            rocket.setFuel(calculateNewWeight(interval, rocket.getFuel(), rocket.getMassLossRate()));

            rocket.saveStep(passedTime);
            passedTime += interval;
        } else {
            running = false;
        }
    }

    @Override
    double getNewVelocity(long deltaTime, double v1) {
        return (rocket.getResultingForce()) / rocket.getFullWeight() * deltaTime / 1000.0 + v1;
    }

    private void calculatePrediction() {
        double sum = rocket.getVelocity() + getNewVelocity(interval, getNewVelocity(interval, rocket.getVelocity()));
        rocket.setVelocity(sum / 2.0);
    }

    private void calculateResultingForce() {
        rocket.setResultingForce(calculateResultingForce(rocket.getForce(), rocket.getGravity()));
    }

    private void calculateGravitation() {
        rocket.setGravity(calculateGravitation(rocket.getBaseMass() + rocket.getFuel(), rocket.getHeight() + Constant.EARTH_RADIUS_M));
    }
}
