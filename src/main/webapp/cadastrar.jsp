<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fiap.model.Attributes" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>Cadastrar Preset</title>
</head>
<body>
	<% Attributes attr = new Attributes(); %>
	<div
		class="d-flex flex-column vh-100 vw-100 align-items-center justify-content-center"
		style="background: linear-gradient(to right, #0060FF 0%, #00BBFF 100%);">
		<p class="fs-1 mb-5" style="color: #fff; font-weight: bold;">Cadastrar Preset</p>
		<form action="cadastrar" method="post" style="width: 90%">
			<div class="row align-items-center justify-content-center mb-4">
				<input class="form-control" type="text" placeholder="Nome da Preset" name="nome" style="max-width: 400px" required>
			</div>
			<div class="row align-items-center justify-content-center mb-5">
				<div class="col-8 col-sm-6 col-md-4 col-lg-4 col-xl me-3">
					<div class="row">
						<div class="w-50">
							<label class="fs-6 mb-2" for="body" style="color: #fff; font-weight: bold;">Corpo</label>
							<select class="form-select col-sm-6 mb-3" id="body" name="body" required>
								<option selected disabled hidden value="">Escolher</option>
								<%
								for (String[] body : attr.bodies){
									out.println("<option value=\""+body[0]+"\">"+body[1]+"</option>");
								}
								%>
							</select>
						</div>
						<div class="w-50">
							<label class="fs-6 mb-2" for="cor" style="color: #fff; font-weight: bold;">Cor</label>
							<select class="form-select col-sm-6 mb-3" id="cor" name="cor" required>
								<option selected disabled hidden value="">Escolher</option>
								<option value="Nenhuma" 
								<% if (request.getParameter("cor") != null && request.getParameter("cor").equals("Nenhuma")) { %> 
									selected
								<% } %>
								>Nenhuma</option>
								<%
								for (String[] cor : attr.cores){
									out.println("<option value=\""+cor[0]+"\" style=\"background-color: "+cor[2]+"\">"+cor[1]+"</option>");
								}
								%>
							</select>
						</div>
					</div>
					<% if (request.getParameter("nome") != null) {out.println("<img src=\"./assets/bodies/"+request.getParameter("body")+"-"+request.getParameter("cor")+".jpg\" class=\"rounded mx-auto d-block w-75 mt-2\">");} %>
				</div>
				<div class="col-8 col-sm-6 col-md-4 col-lg-4 col-xl me-3">
					<label class="fs-6 mb-2" for="decal" style="color: #fff; font-weight: bold;">Decal</label>
					<select class="form-select col-sm-6 mb-3" id="decal" name="decal" required>
						<option selected disabled hidden value="">Escolher</option>
						<%
						for (String[] decal : attr.decals){
							out.println("<option value=\""+decal[0]+"\">"+decal[1]+"</option>");
						}
						%>
					</select>
					<% if (request.getParameter("nome") != null) {out.println("<img src=\"./assets/decals/"+request.getParameter("decal")+".webp\" class=\"rounded mx-auto d-block w-75 mt-4\">");} %>
				</div>
				<div class="col-8 col-sm-6 col-md-4 col-lg-4 col-xl me-3">
					<label class="fs-6 mb-2" for="roda" style="color: #fff; font-weight: bold;">Roda</label>
					<select class="form-select col-sm-6 mb-3" id="roda" name="roda" required>
						<option selected disabled hidden value="">Escolher</option>
						<%
						for (String[] roda : attr.rodas){
							out.println("<option value=\""+roda[0]+"\">"+roda[1]+"</option>");
						}
						%>
					</select>
					<% if (request.getParameter("nome") != null) {out.println("<img src=\"./assets/rodas/"+request.getParameter("roda")+".jpg\" class=\"rounded mx-auto d-block w-75 mt-4\">");} %>
				</div>
				<div class="col-8 col-sm-6 col-md-4 col-lg-4 col-xl me-3">
					<label class="fs-6 mb-2" for="boost" style="color: #fff; font-weight: bold;">Boost</label>
					<select class="form-select col-sm-6 mb-3" id="boost" name="boost" required>
						<option selected disabled hidden value="">Escolher</option>
						<%
						for (String[] boost : attr.boosts){
							out.println("<option value=\""+boost[0]+"\">"+boost[1]+"</option>");
						}
						%>
					</select>
					<% if (request.getParameter("nome") != null) {out.println("<img src=\"./assets/boosts/"+request.getParameter("boost")+".jpg\" class=\"rounded mx-auto d-block w-75 mt-4\">");} %>
				</div>
			</div>
			<div class="row align-items-center justify-content-center mb-4">
				<a role="button" class="btn btn-light me-3" href="alterar.jsp" style="width: 100px; color: #fff; font-weight: bold; background-color: #e303fc">Alterar</a>
				<a role="button" class="btn btn-light me-5" href="consulta.jsp" style="width: 100px; color: #fff; font-weight: bold; background-color: #fc8403">Consultar</a>
				<button type="submit" class="btn btn-success" style="width: 100px">Cadastrar</button>
			</div>
		</form>
		<%
		if (request.getAttribute("popup") != null){
			if ((int)request.getAttribute("popup") == 0){
		%>
				<div class="alert alert-success" role="alert" style="text-align: center">Sua preset foi salva com sucesso!</div>
		<%
			} else if ((int)request.getAttribute("popup") == 1){
		%>
				<div class="alert alert-warning" role="alert" style="text-align: center">O nome de preset indicado já existe. Tente novamente com outro nome!</div>
		<%
			}
		}
		%>	
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>