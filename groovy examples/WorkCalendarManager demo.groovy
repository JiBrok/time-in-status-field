import com.jibrok.jira.plugins.timeinstatus.calendar.manager.*
import com.jibrok.jira.plugins.timeinstatus.calendar.*

@WithPlugin('com.jibrok.jira.plugins.time-in-status')
@PluginModule
WorkCalendarManager workCalendarManager

def calendarId = 1;
def workCalendar = workCalendarManager.get(1);
//def workCalendar = workCalendarManager.getDefault();

def now = new Date()
def afterFiveDays = new Date() + 5

workCalendar.getNextWorkDateTime(now)
workCalendar.isWorkingTime(now)
workCalendar.getWorkTimeBetweenDates(now, afterFiveDays)//get seconds
workCalendar.addWorkTime(now, 1*24*3600  + 10*3600)//add 1day 10h (in seconds)



