/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.SerializationHelper;

/**
 *
 * @author Rossen
 */
public class HearthDiseaseClassifier extends Classifier {

    private final static String classificationTask = "HearthDisease";
    private final static String pathToClassifier = System.getProperty("user.dir") + "\\data\\classifiers\\Nb_HearthDisease.model";

    public HearthDiseaseClassifier() {
        super(classificationTask);
    }

    public String Classify(double[] attributes) {
        String predValue = "";
        for (int i = 0; i < dataStructure.numAttributes() - 1; i++) {
            dataToBeClassified.setValue(attributesList.get(i), attributes[i]);
        }
        dataToBeClassified.setDataset(dataStructure);
        try {
                NaiveBayes cls = (NaiveBayes) SerializationHelper.read(pathToClassifier);
                double pred = cls.classifyInstance(dataToBeClassified);
                predValue = dataStructure.classAttribute().value((int) pred);
                return predValue;

        } catch (Exception e) {
            e.printStackTrace();
            predValue = "";
        } finally {
            return predValue;
        }
    }
}
