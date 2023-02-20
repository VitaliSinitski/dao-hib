package com.vitali.dao.command;

import javax.servlet.http.HttpServletRequest;

public interface CrudCommand {
    String execute(HttpServletRequest request);
}
