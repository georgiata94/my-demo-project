package com.demoproject.navigatorpages.pages.admin.qualifications.education;

import com.demoproject.navigatorpages.pages.admin.qualifications.BaseAddQualificationPage;
import com.demoproject.navigatorpages.pages.admin.qualifications.Education;

public class AddEducation extends BaseAddQualificationPage<AddEducation> {
    @Override
    protected AddEducation self() {
        return this;
    }

    public Education clickSaveButton() {
        return super.clickSaveButton(Education::new);
    }
}
