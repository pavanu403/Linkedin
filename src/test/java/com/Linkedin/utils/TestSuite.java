package com.Linkedin.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.Linkedin.common.LinkedinForgotpassword;
import com.Linkedin.common.LinkedinLogin;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LinkedinLogin.class,LinkedinForgotpassword.class})

public class TestSuite{
}