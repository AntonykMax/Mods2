package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private NumberAxis p;

    @FXML
    private JFXButton button;

    @FXML
    private JFXCheckBox check1;

    @FXML
    private JFXTextField fieldA;

    @FXML
    private JFXCheckBox check2;

    @FXML
    private JFXCheckBox check3;

    @FXML
    private JFXCheckBox check4;

    @FXML
    private JFXCheckBox check5;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private CategoryAxis m;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonPressed(ActionEvent actionEvent) {
        chart.getData().retainAll();
        if(check1.isSelected()) {
            int a = Integer.parseInt(fieldA.getText());
            List<XYChart.Series> series = new ArrayList<>();
            for (int j = 0; j < Constanta.N; j++) {
                series.add(new XYChart.Series());
                series.get(j).setName("Временной слой " + j);
                for (int i = 0; i < Constanta.M; i++)
                    series.get(j).getData().add(new XYChart.Data(Integer.toString(i), (Linear.S1(a)[j][i]) + 0.5 * j));
                chart.getData().add(series.get(j));
            }
        } else if(check2.isSelected()){
            int a = Integer.parseInt(fieldA.getText());
            List<XYChart.Series> series = new ArrayList<>();
            for (int j = 0; j < Constanta.N; j++) {
                series.add(new XYChart.Series());
                series.get(j).setName("Временной слой " + j);
                for (int i = 0; i < Constanta.M; i++)
                    series.get(j).getData().add(new XYChart.Data(Integer.toString(i), (Linear.S2(a)[j][i]) + 0.5 * j));
                chart.getData().add(series.get(j));
            }
        } else if(check3.isSelected()){
            int a = Integer.parseInt(fieldA.getText());
            List<XYChart.Series> series = new ArrayList<>();
            for (int j = 0; j < Constanta.N; j++) {
                series.add(new XYChart.Series());
                series.get(j).setName("Временной слой " + j);
                for (int i = 0; i < Constanta.M; i++)
                    series.get(j).getData().add(new XYChart.Data(Integer.toString(i), (Linear.S3(a)[j][i]) + 0.5 * j));
                chart.getData().add(series.get(j));
            }
        } else if(check4.isSelected()){
            List<XYChart.Series> series = new ArrayList<>();
            for (int j = 0; j < Constanta.N; j++) {
                series.add(new XYChart.Series());
                series.get(j).setName("Временной слой " + j);
                for (int i = 0; i < Constanta.M; i++)
                    series.get(j).getData().add(new XYChart.Data(Integer.toString(i), (Unlinear.S4()[j][i]) + 0.5 * j));
                chart.getData().add(series.get(j));
            }
        } else if(check5.isSelected()){
            List<XYChart.Series> series = new ArrayList<>();
            for (int j = 0; j < Constanta.N - 1; j++) {
                series.add(new XYChart.Series());
                series.get(j).setName("Временной слой " + j);
                for (int i = 0; i < Constanta.M; i++)
                    series.get(j).getData().add(new XYChart.Data(Integer.toString(i), (Unlinear.S5()[j][i]) + 0.5 * j));
                chart.getData().add(series.get(j));
            }
        }
    }
}
