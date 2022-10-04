# relatorio-jasper-via-api
No JasperPrint caso não se passe nenhum DataSource, deve se passar um dataSource vazio como: <br>
JasperPrint print = JasperFillManager.fillReport(comipledReport, parametros, new JREmptyDataSource());
