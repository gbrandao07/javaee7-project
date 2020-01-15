package br.com.javaee7.batch.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.JobExecution;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author gustavo
 *
 */
@WebServlet("/batch")
public class BatchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private JobOperator jobOperator;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long jobExecutionId = jobOperator.start("my_batch_job", new Properties());
		
		JobExecution jobExecution = jobOperator.getJobExecution(jobExecutionId);

		response.getWriter().append("Batch Job started...\n\n\n");
		
		while(jobExecution.getExitStatus() == null) {
			continue;
		}
		
		response.getWriter().append("Job result: " + jobExecution.getExitStatus() + "\nStart at: " + jobExecution.getCreateTime() + 
				"\nEnd at: " + jobExecution.getEndTime());
	}
}
