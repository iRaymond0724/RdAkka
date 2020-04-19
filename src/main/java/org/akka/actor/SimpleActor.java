/**
 * (C) Copyright 2014 Roy Russo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 */


package org.akka.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.akka.command.Command;
import org.akka.event.Event;
import utils.HttpClientUtil;


import java.util.*;
import java.util.UUID;

/**
 * SimpleActor receives an instance of Command and emits an Event.
 *
 * @author royrusso
 */
public class SimpleActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);


    public SimpleActor() {
        log.info("SimpleActor constructor");
    }

    @Override
    public void onReceive(Object msg) throws Exception {

        log.info("Received Command: " + msg);

        if (msg instanceof Command) {
            final String data = ((Command) msg).getData();
            final Event event = new Event(data, UUID.randomUUID().toString());
            final ActorSystem actorSystem = ActorSystem.create("actor-system");
            final ActorRef actorRef = actorSystem.actorOf(Props.create(helloActor.class), "hello-actor");
            actorRef.tell(new Command("aka刀槍不入"),null);
//            System.out.println("get Message+++++++++++++++++++++++++++++");
            log.info("Received Msg: " + msg);
            // emmit an event somewhere...


        } else if (msg.equals("echo")) {
            log.info("ECHO!");
        }
    }

}
