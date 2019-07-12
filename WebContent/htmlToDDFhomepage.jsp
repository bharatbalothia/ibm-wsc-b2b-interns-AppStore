<jsp:include page="common\header.jsp" />

<body>


	<div id="wrapper">
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<jsp:include page="common\logout.jsp" />
							<h2 class="date">HTML To DDF Converter</h2><hr/>
							<h3><p>Hello, Please choose the html file for conversion to ddf output format.</p></h3>
							<form method="post" action="../B2BAppStore/HtmlToDDFProcess" enctype="multipart/form-data">
                       
								<strong>Choose file to upload: </strong>&nbsp;<strong
									style="color: red;">*</strong>&nbsp;&nbsp; <input type="file"
									name="file" id="file" size="0" value="C:\\"/> <br /> <br /> <br /> <input
									type="submit" value="Generate DDF">
							</form>
						</div>
						<div class="post">
							<h2 class="date">Description</h2>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
								<h3 class="date">This utility creates .ddf file for .html file</h3><br>
								<div style="font-size: 15px">
								  <b>Input File Format:&nbsp;</b>.html&nbsp;&nbsp;&nbsp;&nbsp;<br>
								  <div style="padding-left: 70px"><b>Output:&nbsp;</b>.ddf</div>
								  <div style="padding-top: 20px;padding-left: 25px"><b>Note : &nbsp;</b>Once .ddf is generated please append &lt;!DOCTYPE GENTRANDDF&gt; tag after &lt;?xml version....&gt; tag. (&nbsp;Refer&nbsp;<a href="resource/outputDDF.ddf"">Sample DDF file</a>&nbsp;)</div>
								  <div style="padding-top: 20px;padding-left: 25px/* ; font-weight: bold; */"><b>Contributors:</b>&nbsp;<i>Prashanth Reddy Gomari, Kshiteej Gilda</i></div>							  
								</div>
								<div style="clear: both;">&nbsp;</div>
							</div>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<jsp:include page="common\sidebar.jsp"></jsp:include>
					<div style="clear: both;">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="common\footer.jsp"></jsp:include>


</body>
</html>