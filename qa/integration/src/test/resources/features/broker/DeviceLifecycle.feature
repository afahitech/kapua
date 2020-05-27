###############################################################################
# Copyright (c) 2017, 2020 Eurotech and/or its affiliates and others
#
# All rights reserved. This program and the accompanying materials are made
# available under the terms of the Eclipse Public License 2.0
# which is available at https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#     Eurotech - initial API and implementation
###############################################################################
@broker
@deviceLifecycle
@integration

Feature: Device lifecycle scenarios

  Scenario: Set environment variables

    Given System property "commons.settings.hotswap" with value "true"
    And System property "broker.ip" with value "localhost"
    And System property "kapua.config.url" with value "null"

  Scenario: Start datastore for all scenarios

    Given Start Datastore

  Scenario: Start event broker for all scenarios

    Given Start Event Broker

  Scenario: Start broker for all scenarios

    Given Start Broker

Scenario: Starting and stopping the simulator should create a device entry and properly set its status
  This starts and stops a simulator instance and checks if the connection state
  is recorded properly.

  Given The account name is kapua-sys and the client ID is sim-1
    And The broker URI is tcp://kapua-broker:kapua-password@localhost:1883
    And My credentials are username "kapua-sys" and password "kapua-password"

  When I start the simulator
  Then Device sim-1 for account kapua-sys is registered after 5 seconds
  And The device should report simulator device information
  And I expect the device to report the applications
    | DEPLOY-V2 |
    | CMD-V1 |

  When I fetch the bundle states
  Then The bundle org.eclipse.kura.api with version 2.1.0 is present and ACTIVE
  And  The bundle org.eclipse.kura.unresolved with version 2.1.2 is present and INSTALLED
  And  The bundle org.eclipse.kura.unstarted with version 2.1.1 is present and RESOLVED

  When I stop the bundle org.eclipse.kura.api with version 2.1.0
  And I fetch the bundle states
  Then The bundle org.eclipse.kura.api with version 2.1.0 is present and RESOLVED

  When I start the bundle org.eclipse.kura.api with version 2.1.0
  And I fetch the bundle states
  Then The bundle org.eclipse.kura.api with version 2.1.0 is present and ACTIVE

  When I stop the simulator
  Then Device sim-1 for account kapua-sys is not registered after 5 seconds

Scenario: Installing a package
  Given The account name is kapua-sys and the client ID is sim-1
    And The broker URI is tcp://kapua-broker:kapua-password@localhost:1883
    And My credentials are username "kapua-sys" and password "kapua-password"

  When I start the simulator
  Then Device sim-1 for account kapua-sys is registered after 5 seconds

  When I fetch the package states
  Then There must be no installed packages

  When I start to download package "foo.bar" with version 1.2.3 from http://127.0.0.1/foo.dp

  Then The download state changes to IN_PROGRESS in the next 5 seconds
   And The download state changes to COMPLETED in the next 30 seconds

  When I fetch the package states
  Then Package "foo.bar" with version 1.2.3 is installed and has 10 mock bundles

  Scenario: Stop broker after all scenarios

    Given Stop Broker

  Scenario: Stop event broker for all scenarios

    Given Stop Event Broker

  Scenario: Stop datastore after all scenarios

    Given Stop Datastore
