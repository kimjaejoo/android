/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2016-12-19 01:25:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import example.db.DB;
import java.sql.*;
import com.tomato.xml.*;

public final class addressList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.tomato.xml");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("example.db.DB");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");


/***************************************************************************
* Set the character encoding to utf-8
***************************************************************************/
request.setCharacterEncoding("utf-8");
/**************************************************************************
* Gain parameter received from client ("Name" searching conditon of Search Part)
**************************************************************************/
String strSearchName = (String)request.getParameter("searchName");

/**************************************************************************
* Database variable declaration
**************************************************************************/
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

/**************************************************************************
* XML Document(XML Conversion document) Creation
**************************************************************************/
com.tomato.xml.XTMDocument doc = new XTMDocument();


    /**************************************************************************
    * sample.db Connect 
    **************************************************************************/
    DB db = DB.getInstance();
    conn = db.getConnection("sample");
        String[][] a = {{"seq","INTEGER PRIMARY KEY AUTOINCREMENT"},{"name","NVARCHAR(50)"},{"zipcode","NVARCHAR(20)"},{"address","NVARCHAR(255)"},{"officetel","NVARCHAR(30)"},{"hptel","NVARCHAR(30)"}};
        db.createTable("sample","address", a);
    try {	
    /**************************************************************************
    * Query Creation
    **************************************************************************/
    StringBuffer strBuffer = new StringBuffer();

    strBuffer.append("SELECT seq                ")
             .append("     , name               ")
             .append("     , zipcode            ")
             .append("     , address            ")
             .append("     , officetel          ")
             .append("     , hptel              ")
             .append("  FROM address            ");

    if(strSearchName != null && !"".equals(strSearchName))
        strBuffer.append(" WHERE name like '%").append(strSearchName).append("%'");

    /**************************************************************************
    * Get ResultSet
    **************************************************************************/
    stmt= conn.createStatement();
    rs = stmt.executeQuery(strBuffer.toString());
    /******************************************************
    ********************
    * Repeat Node Creation
    * <addressList>
    *   <list>
    *      <seq>Value 1</seq>
    *      <name>Value 2</name>
    *      <zipcode>Value 3</zipcode>
    *      <address>Value 4</address>
    *      <officetel>Value 5</officetel>
    *      <hptel>Value 6</hptel>
    *   </list>
    * </addressList>
    **************************************************************************/
    com.tomato.xml.Repeater    rpt = new Repeater("addressList","","list");	

    /**************************************************************************
    * Put XML Document after putting ResultSet on Repeater
    **************************************************************************/
    rpt.store(rs);	
    doc.appendChild((Repeater)rpt); 	    
            
} catch(Exception e){
    e.printStackTrace();
    doc.setAttribute("message",e.toString());
    doc.setAttribute("replace","false" );
} finally {
    /**************************************************************************
    * Garbage Collection
    **************************************************************************/
    if(rs != null) rs.close();
    if(stmt != null) stmt.close();
    if(conn != null) conn.close();
    /**************************************************************************
    * Write XML document on JSP
    **************************************************************************/
    out.print(doc.toString());
}

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
