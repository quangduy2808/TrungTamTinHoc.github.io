<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
  <div class="col-sm-6">
    <form:form id="editForm" method="post" modelAttribute="user" data-parsley-validate="data-parsley-validate">
    <form:hidden id="password" path="password"  required="" />
    <form:hidden id="id" path="id"  required="" />
      <div class="form-group row">
        <label class="form-control-label col-sm-3">Phân quyền<span class="required">*</span></label>
      <div class="col-sm-9">
          <form:select path="role" cssClass="form-control" >
          <form:option value="ROLE_ADMIN">ADMIN</form:option>
          <form:option value="ROLE_USER">USER</form:option>
          </form:select>
        </div>
      </div>
      <div class="ln_solid"></div>
      <div class="form-group row">
        <div class="col-sm-8 col-sm-offset-1">
          <button  class="btn btn-primary" style="width: 100px;" id="btnSave">Lưu</button>
          <button type="button" class="btn btn-default">Hủy</button>
        </div>
      </div>
      <!-- hidden field -->
      <input type="hidden" name="crudaction" value="insert-update" />
    </form:form>
  </div>
</div>
