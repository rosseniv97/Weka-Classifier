/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekaapplication;

import java.io.File;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.LMT;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;
import java.util.Scanner;

/**
 *
 * @author Rossen
 */
public class ModelGenerator {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\2019_ 2020\\Дипломна работа\\HearthDiseasePrediction\\framingham.arff");
        Instances traindataset = source.getDataSet();
        traindataset.setClassIndex(traindataset.numAttributes() - 1);
        System.out.println("Type option:");
        String option = sc.next();
        switch (option) {
            case "logistic": {
                String path = System.getProperty("user.dir") + "\\data\\classifiers\\Logistic_HearthDisease.model";
                File classFile = new File(path);
                classFile.createNewFile();

                Logistic logistic = new Logistic();
                logistic.buildClassifier(traindataset);

                SerializationHelper.write(path, logistic);
            }break;
            case "nb": {
                String path = System.getProperty("user.dir") + "\\data\\classifiers\\Nb_HearthDisease.model";
                File classFile = new File(path);
                classFile.createNewFile();

                NaiveBayes nb = new NaiveBayes();
                nb.buildClassifier(traindataset);

                SerializationHelper.write(path, nb);
            }break;
            case "smo": {
                String path = System.getProperty("user.dir") + "\\data\\classifiers\\SMO_HearthDisease.model";
                File classFile = new File(path);
                classFile.createNewFile();

                SMO smo = new SMO();
                smo.buildClassifier(traindataset);

                SerializationHelper.write(path, smo);
            }break;
            case "lmt": {
                String path = System.getProperty("user.dir") + "\\data\\classifiers\\LMT_HearthDisease.model";
                File classFile = new File(path);
                classFile.createNewFile();

                LMT lmt = new LMT();
                lmt.buildClassifier(traindataset);

                SerializationHelper.write(path, lmt);
            }break;
            
            default: System.out.println("Type correct option:");

        }
    }
}
