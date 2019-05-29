package com.briup.crm.common.exception;

import java.util.HashMap;
import java.util.Map;

public class CrmCommonException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Map<Integer, CrmCommonException> exceptionMap = new HashMap<Integer, CrmCommonException>();
	private static final Map<Integer, String> errmsgMap = new HashMap<Integer, String>();

	static {
		errmsgMap.put(401, "����Ϊ��!");
		errmsgMap.put(402, "�û����������!");
		errmsgMap.put(403, "��������");
		errmsgMap.put(404, "��ѯ���Ϊ�գ�");
		exceptionMap.put(501, new CrmCommonException(501, getMessage(501)));
	}

	private int errcode;
	private String errmsg;

	public CrmCommonException(int errcode, String msg) {
		super(msg);
		this.errcode = errcode;
		this.errmsg = msg;
	}

	public int getErrcode() {
		return errcode;
	}

	@Override
	public String getMessage() {
		return errmsg;
	}

	public static String getMessage(int errcode) {
		if (errmsgMap.containsKey(errcode)) {
			return errmsgMap.get(errcode);
		}
		else {
			return errmsgMap.get(501);
		}
	}

	public static CrmCommonException getException(int errcode) {
		if (exceptionMap.containsKey(errcode)) {
			return exceptionMap.get(errcode);
		} else if (errmsgMap.containsKey(errcode)) {
			CrmCommonException ex = new CrmCommonException(errcode, getMessage(errcode));
			exceptionMap.put(errcode, ex);
			return ex;
		} else {
			return exceptionMap.get(501);
			
		}
	}

}
