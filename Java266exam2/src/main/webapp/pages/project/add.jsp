<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-6">
		<form:form id="editForm" method="post" modelAttribute="project"
			data-parsley-validate="data-parsley-validate">

			<div class="form-group row">
				<label class="form-control-label col-sm-3">Tên dự án<span
					class="required">*</span></label>
				<div class="col-sm-9">
					<form:input id="name" path="name" cssClass="form-control"
						required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Phòng ban<span
					class="required">*</span></label>
				<div class="col-sm-9">
					<form:select path="iddepartment">
						<form:options items="${map}" />
					</form:select>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group row">
				<div class="col-sm-8 col-sm-offset-1">
					<button class="btn btn-primary" style="width: 100px;" id="btnSave">Thêm
						mới</button>
					<button type="button" class="btn btn-default">Hủy</button>
				</div>
			</div>
			<!-- hidden field -->
			<input type="hidden" name="crudaction" value="insert-update" />
		</form:form>
	</div>
</div>
