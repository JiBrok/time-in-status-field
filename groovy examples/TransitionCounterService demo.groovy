import com.jibrok.jira.plugins.timeinstatus.api.TransitionCounterDataDto
import com.jibrok.jira.plugins.timeinstatus.api.TransitionCounterService

@WithPlugin('com.jibrok.jira.plugins.time-in-status')
@PluginModule
TransitionCounterService transitionCounterService

def issueId = 10566

def statusId = [
        inProgress: "3",
        Done      : "10001",
        Open      : "1"
]

def countTransitionsFromInProgress = transitionCounterService.getFrom(issueId, statusId.inProgress)



def transitionCounterDataDto = TransitionCounterDataDto
        .builder()
        .fromStatuses([statusId.inProgress, statusId.Done] as Set)
        .toStatuses([statusId.Open] as Set)
        .build()
/*
def transitionCounterDataDto = new TransitionCounterDataDto();
transitionCounterDataDto.setFromStatuses([statusId.inProgress, statusId.Done] as Set)
        .setToStatuses([statusId.Open] as Set)

def transitionCounterDataDto = new TransitionCounterDataDto();
transitionCounterDataDto.setFromStatuses([] as Set)
        .setToStatuses([statusId.Open] as Set)

def transitionCounterDataDto = new TransitionCounterDataDto();
transitionCounterDataDto.setFromStatuses(null)
        .setToStatuses([statusId.Open] as Set)

*/

transitionCounterService.get(issueId, transitionCounterDataDto)



