<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="account-bg">
	<div class="card-box m-b-0">
		<div class="text-xs-center m-t-20">
			<a href="index.html" class="logo"> <img alt="logo"
				src='<c:url value="/images/logo.png"/>' width="300">
			</a>
		</div>
		<div class="m-t-10 p-20">
		
			<form class="m-t-20" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group row">
					<div class="col-xs-12">
						<input class="form-control" type="email" required="required"
							placeholder="Email">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-xs-12">
						<input class="form-control" type="text" required="required"
							placeholder="username" name="username">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-xs-12">
						<input class="form-control" type="password" placeholder="Password"
							name="password">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-xs-12">
						<div class="checkbox checkbox-primary">
							<input id="checkbox-signup" type="checkbox" checked="checked">
							<label for="checkbox-signup">Tôi đồng ý <a href="#">các
									điều khoản và điều kiện</a></label>
						</div>
					</div>
				</div>

				<div class="form-group row text-center m-t-10">
					<div class="col-xs-12">
						<button class="btn btn-success btn-block waves-effect waves-light"
							type="submit">Đăng ký</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end card-box-->

<div class="m-t-20">
	<div class="text-xs-center">
		<p class="text-white">
			Đã có tài khoản? <a href="pages-login.html" class="text-white m-l-5"><b>Đăng
					nhập</b> </a>
		</p>
	</div>
</div>