import com.onresolve.scriptrunner.runner.customisers.PluginModule
import com.onresolve.scriptrunner.runner.customisers.WithPlugin
import com.jibrok.jira.plugins.timeinstatus.api.*
import com.atlassian.jira.component.ComponentAccessor;

@WithPlugin('com.jibrok.jira.plugins.time-in-status')
@PluginModule
TimeInStatusService timeInStatusService

def issue = ComponentAccessor.getIssueManager().getIssueObject("TEST-823")

//deprecated
timeInStatusService.calculateTimeInStatus(
    issue,
    ["10000"],//status id
    true,//calculateAfterMove
    true//calculateAfterLastTransition
)



timeInStatusService.calculate(
    issue,
    new ParametersForCalculationTimeInStatusDto(
      //All parameters are optional. 
    	[
          statusIds: ["10000"],
          calculateAfterMove: true,
          calculateLastTransition: false,
          calculateFirstTransition: false,
          workCalendarId: 0,
          useCache: false,
          from: null,
          to: new Date()
        ]
    )
)



