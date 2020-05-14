/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

/**
 *
 * @author Rossen
 */
import java.io.File;
import java.util.ArrayList;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.*;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;
import weka.filters.unsupervised.attribute.Discretize;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMO;

public class Classifier {

    private final static String pathToClassifier = System.getProperty("user.dir") + "\\data\\classifiers\\Nb.model";
    private static String method;
    private static Instances dataSet;
    private static Instance dataToBeClassified;
    private static int numClasses;
    private static ArrayList<Attribute> attributesList;

    public Classifier(String method) {
        this.method = method;
        try {
            DataSource source = new DataSource("D:\\2019_ 2020\\Weka API\\iris_template.arff");
            dataSet = source.getDataSet();
            dataSet.setClassIndex(dataSet.numAttributes() - 1);
            numClasses = dataSet.numClasses();
            attributesList=new ArrayList();
            dataToBeClassified = new DenseInstance(dataSet.numAttributes());

            for (int i = 0; i < dataSet.numAttributes()-1; i++) {
                attributesList.add(dataSet.attribute(i)); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String Clasify(double[] attributes) {
        String predValue = "";
        for (int i = 0; i < dataSet.numAttributes()-1; i++) {
            dataToBeClassified.setValue(attributesList.get(i), attributes[i]);
        }
        dataToBeClassified.setDataset(dataSet);
        try {
            if (method.equals("nb")) {
                NaiveBayes cls = (NaiveBayes) SerializationHelper.read(pathToClassifier);
                double pred = cls.classifyInstance(dataToBeClassified);
                predValue = dataSet.classAttribute().value((int) pred);
                return predValue;
            }

        } catch (Exception e) {
            e.printStackTrace();
            predValue = "";
        } finally {
            return predValue;
        }
    }
}
