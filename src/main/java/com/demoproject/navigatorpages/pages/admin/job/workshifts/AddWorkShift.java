package com.demoproject.navigatorpages.pages.admin.job.workshifts;

import com.demoproject.navigatorpages.pages.admin.job.WorkShifts;
import com.demoproject.utils.ActionHelper;
import com.demoproject.utils.ButtonManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddWorkShift {

    private static final Logger logger = LogManager.getLogger(AddWorkShift.class);

    public AddWorkShift fillShiftName(String text) {
        try {
            logger.info("Filling Shift Name field with text: {}", text);
            ActionHelper.type(ButtonManager.get("common.input.generic.xpath", "Shift Name"), text);
        } catch (Exception e) {
            logger.error("Failed to fill Shift Name field: {}", e.getMessage());
        }
        return this;
    }

    public AddWorkShift fillTimeFrom(String timeFrom) {
        try {
            logger.info("Filling 'From' time field with time: {}", timeFrom);
            ActionHelper.type(ButtonManager.get("common.input.generic.xpath", "From"), timeFrom);
        } catch (Exception e) {
            logger.error("Failed to fill 'From' time field: {}", e.getMessage());
        }
        return this;
    }

    public AddWorkShift fillTimeTo(String timeTo) {
        try {
            logger.info("Filling 'To' time field with time: {}", timeTo);
            ActionHelper.type(ButtonManager.get("common.input.generic.xpath", "To"), timeTo);
        } catch (Exception e) {
            logger.error("Failed to fill 'To' time field: {}", e.getMessage());
        }
        return this;
    }

    public AddWorkShift fillAssignedEmployees(String text) {
        try {
            logger.info("Filling Assigned Employees field with text: {}", text);
            ActionHelper.type(ButtonManager.get("common.input.generic.xpath", "Assigned Employees"), text);
        } catch (Exception e) {
            logger.error("Failed to fill Assigned Employees field: {}", e.getMessage());
        }
        return this;
    }

    public WorkShifts clickSaveButton() {
        logger.info("Clicking 'Save' button for Work Shift.");

        try {
            ActionHelper.waitForPageLoad();
            ActionHelper.waitForVisibility(ButtonManager.get("common.button.save.xpath"));

            ActionHelper.jsClick(ButtonManager.get("common.button.save.xpath"));
            logger.info("'Save' button clicked.");

            try {
                ActionHelper.waitForVisibility(ButtonManager.get("common.button.add.xpath"));
                logger.info("Add button is visible. Save successful.");
                return new WorkShifts();
            } catch (Exception e) {
                logger.error("Add button not visible after clicking 'Save'.");
                throw new RuntimeException("Add button not visible after clicking 'Save'.");
            }

        } catch (Exception e) {
            logger.error("Error while clicking 'Save' button: {}", e.getMessage());
            throw new RuntimeException("Failed to click 'Save' button or wait for Add button.", e);
        }
    }




    public WorkShifts clickCancelButton() {
        try {
            logger.info("Clicking 'Cancel' button for Work Shift.");
            ActionHelper.click(ButtonManager.get("common.button.cancel.xpath"));
        } catch (Exception e) {
            logger.error("Error while clicking 'Cancel' button: {}", e.getMessage());
        }
        return new WorkShifts();
    }
}
