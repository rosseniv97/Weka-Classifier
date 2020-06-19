/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import weka.classifiers.meta.CostSensitiveClassifier;
import weka.core.SerializationHelper;

/**
 *
 * @author Rossen
 */
public class Covid19Classifier extends Classifier {
    private final static String classificationTask = "Covid19";
    private final static String pathToClassifier = System.getProperty("user.dir") 
            + "\\data\\classifiers\\Covid19_Logistic.model";
    
    public Covid19Classifier() {
        super(classificationTask);
    }
    public String Classify(double[]attributes) {
        String predValue = "";
        for (int i = 0; i < dataStructure.numAttributes() - 1; i++) {
            dataToBeClassified.setValue(attributesList.get(i), attributes[i]);
        }
        dataToBeClassified.setDataset(dataStructure);
        try {
            CostSensitiveClassifier cls = (CostSensitiveClassifier) SerializationHelper.read(pathToClassifier);
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
