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
  */

package org.akka.app;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.akka.actor.SimpleActor;
import org.akka.command.Command;
import org.akka.command.hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main runtime class.
 */
public class System {

    public static final Logger log = LoggerFactory.getLogger(org.akka.app.System.class);

    public static void main(String... args) throws Exception {

        final ActorSystem actorSystem = ActorSystem.create("actor-system");

//        Thread.sleep(1000);

        final ActorRef simpleActorRef = actorSystem.actorOf(Props.create(SimpleActor.class), "simple-actor");
        final ActorRef helloActorRef = actorSystem.actorOf(Props.create(hello.class), "hello-actor");
        simpleActorRef.tell(new Command("CMD 1"), null);
//        helloActorRef.tell(new  Command("CMD 1"), null);
//        Thread.sleep(1000);

        Thread.sleep(6000);

        // hello

        log.debug("Actor System Shutdown Starting...");
        actorSystem.shutdown();
    }
}
