package com.company;

public class FasrFourierTransformation {

    private final int sampleRate = 100;
    final int someFuncSize = 100;
    float[] someFunc = new float[someFuncSize];


    public FasrFourierTransformation() {
        for (int i = 0; i < someFunc.length; i++) {
            someFunc[i] = someFun(i);
        }
    }

    private float someFun(int index) {
        //final int amplitudeOfSecondHarmonic = 1;
        final int frequencyOfFirstHarmonic = 2;
        //final int frequencyOfSecondHarmonic = 880;

        return (float)Math.cos((frequencyOfFirstHarmonic * 2 * Math.PI  * index ) / sampleRate);
    }

    private float cos(int index, int frequency, int sampleRate) {
        return (float)Math.cos((2 * Math.PI * frequency * index) / sampleRate);
    }
    private float sin(int index, int frequency, int sampleRate) {
        return (float)Math.sin((2 * Math.PI * frequency * index) / sampleRate);
    }

    private float[] dft(float[] frame, int sampleRate) {
        final int resultSize = sampleRate / 2;
        float[] result = new float[resultSize * 2];
        for (int i = 0; i < result.length / 2; i++) {
            int frequency = i;
            for (int j = 0; j < frame.length; j++) {
                result[2*i] +=frame[j] * cos(j, frequency, sampleRate);
                result[2*i + 1] +=frame[j] * sin(j, frequency, sampleRate);
            }
            result[2*i] =result[2*i] / resultSize;
            result[2*i + 1] = result[2*i + 1] / resultSize;
        }

        return result;
    }

    public float[] func (){
        float[] result;
        long start = System.currentTimeMillis();
        result = dft(someFunc, sampleRate);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("Time's dft: " + timeConsumedMillis);
        float[] amplitude = new float[sampleRate/2];
        for (int i = 0; i < result.length / 2; i++) {
            amplitude[i] = (float)Math.sqrt(result[2*i]*result[2*i] + result[2*i+1]*result[2*i+1]);
            System.out.println(i + ": " + "Projection on cos: " + result[2*i] + " Projection on sin: " + result[2*i + 1]
                    + " amplitude: "+ amplitude[i] + "\n");
        }
        return amplitude;
    }

}
