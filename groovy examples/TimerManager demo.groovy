import com.jibrok.jira.plugins.timeinstatus.api.*;

@WithPlugin('com.jibrok.jira.plugins.time-in-status')
@PluginModule
TimerManager timerManager


def issueId = 10001
def timerFieldId = 10001
def timerAction = new TimerActionDto(Action.START, issueId, timerFieldId, true, true);
timerManager.doAction(timerAction)


@PluginModule
StopwatchManager stopwatchManager

def stopwatchFieldId = 10001
def stopwtchAction = new StopwatchActionDto(Action.PAUSE, issueId, stopwatchFieldId, true, true);
stopwatchManager.doAction(stopwtchAction)


