package controller;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;

public class ShowChartAction extends ActionSupport {
	private JFreeChart chart;
	String type;
	String titlename;
	String cagetoryname;
	String valuename;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitlename() {
		return titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public String getCagetoryname() {
		return cagetoryname;
	}

	public void setCagetoryname(String cagetoryname) {
		this.cagetoryname = cagetoryname;
	}

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

	public JFreeChart getChart() throws Exception {

		JFreeChart chart = null;
		
			DefaultCategoryDataset dcd = (DefaultCategoryDataset) ServletActionContext.getRequest().getAttribute("dcd");
			
			chart = ChartFactory.createBarChart3D(titlename, cagetoryname, valuename, dcd, PlotOrientation.VERTICAL,
					true, true, true);
			chart.getTitle().setFont(new Font("����", 0, 12));
			CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
			NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
			CategoryAxis domainAxis = categoryplot.getDomainAxis();
			TextTitle textTitle = chart.getTitle();

			textTitle.setFont(new Font("����", Font.PLAIN, 20));

			domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

			domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));

			numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

			numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));

			chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

			BarRenderer3D renderer = new BarRenderer3D();

			// ����ÿ��������������ƽ������֮�����
			renderer.setItemMargin(0.1);
			// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
			renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setItemLabelsVisible(true);

			categoryplot.setRenderer(renderer);

		String uploadPath = ServletActionContext.getServletContext().getRealPath("upload");
		String realPath = ServletActionContext.getRequest().getRealPath("/upload");

		String imgname = ServletActionContext.getRequest().getAttribute("imgname").toString();
		OutputStream os = new FileOutputStream(realPath + "\\" + imgname);
		File toFile = new File(uploadPath, imgname);
		if (!toFile.getParentFile().exists()) {
			// ���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
			System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
			if (!toFile.getParentFile().mkdirs()) {
				System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");
			}
		}
		ChartUtilities.writeChartAsPNG(os, chart, 600, 460);
		ServletActionContext.getRequest().setAttribute("imgname", imgname);
		os.close();
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String execute() throws Exception {
		this.getChart();
		return null;
	}
}
