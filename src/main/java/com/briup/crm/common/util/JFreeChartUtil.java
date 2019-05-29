package com.briup.crm.common.util;

import java.awt.Color;
import java.awt.Font;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.TextAnchor;

public class JFreeChartUtil {
	public static String createBarChart(String title, String categoryAxisLabel, String valueAxisLabel,CategoryDataset dataset,HttpServletRequest request) throws Exception {
		// ���� ������ ������ ���ݼ�
		JFreeChart chart = ChartFactory.createBarChart3D(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, // ͼ��ķ���
				true, // �Ƿ���ʾͼ��
				true, // �Ƿ���ʾ������ʾ
				true);// �Ƿ����url����
		// ��������
		// ������������
		chart.getTitle().setFont(new Font("����", Font.PLAIN, 18));
		// �����ӱ�������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 18));

		// ��ȡͼ�εĻ��ƻ���
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();

		// �������񱳾���ɫ
		categoryPlot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		categoryPlot.setDomainGridlinePaint(Color.pink);
		// �������������ɫ
		categoryPlot.setRangeGridlinePaint(Color.pink);
		// ��ȡx��
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();
		// ��ȡy��
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();

		// ����x��������
		categoryAxis3D.setLabelFont(new Font("����", Font.PLAIN, 11));
		// ����x��������
		categoryAxis3D.setTickLabelFont(new Font("����", Font.PLAIN, 11));

		// ����y����������
		numberAxis3D.setLabelFont(new Font("����", Font.PLAIN, 12));
		numberAxis3D.setTickLabelFont(new Font("����", Font.PLAIN, 12));

		// ����y��Ŀ̶�
		numberAxis3D.setAutoTickUnitSelection(true);
		NumberTickUnit unit = new NumberTickUnit(40);
		numberAxis3D.setTickUnit(unit);

		// ��ʾ������ֵ�����޸ĸ���ֵ����������
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);

		barRenderer3D.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

		barRenderer3D.setBaseItemLabelFont(new Font("����", Font.PLAIN, 15));
		barRenderer3D.setMaximumBarWidth(0.05);
		String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400, null, request.getSession());
		return fileName;
	}
}
