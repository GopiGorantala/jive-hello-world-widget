package com.jivesoftware.helloworld;

import com.jivesoftware.community.annotations.PropertyNames;
import com.jivesoftware.community.widget.*;

import java.util.Map;


//@PropertyNames("myProperty")
@WidgetTypeMarker({WidgetType.HOMEPAGE, WidgetType.SOCIALGROUP,
        WidgetType.COMMUNITY, WidgetType.PROJECT,WidgetType.CONTAINER})
@PropertyNames("greetUser")
public class HelloWorldWidget extends BaseWidget {

    private boolean greetUser = true;

    @Override
    public String getTitle(WidgetContext widgetContext) {
        return "Hello World Widget";
    }

    @Override
    public String getDescription(WidgetContext widgetContext) {
        return "Displays a 'Hello World' message.";
    }

    @Override
    public String render(WidgetContext widgetContext,
                         ContainerSize containerSize) {
        // Process the included FTL file to render the HTML for display.
        return applyFreemarkerTemplate(widgetContext, containerSize,
                "/plugins/jive-hello-world-widget/resources/templates/helloWorld-Page.ftl");
    }

    public boolean getGreetUser() {
        return greetUser;
    }

    public void setGreetUser(boolean greetUser) {
        this.greetUser = greetUser;
    }

    protected Map<String, Object> loadProperties(WidgetContext widgetContext,
                                                 ContainerSize containerSize) {
        // First load existing properties.
        Map<String, Object> properties = super.loadProperties(widgetContext,
                containerSize);

        // Get the name of the community this instance is in, then add it as a
        // property.
//        String widgetType = widgetContext.getWidgetType().name();
        String communityName=" ? ";
//        if(widgetType.equals("COMMUNITY"))
//            communityName = ((CommunityWidgetContext)widgetContext).getCommunity().getName();
        properties.put("communityName", communityName);

        String userName = widgetContext.getUser().getName();
        properties.put("userName", userName);
        properties.put("greetUser", greetUser);

        return properties;
    }

}
