#!/usr/bin/env bash
###############################################################################
# Copyright (c) 2018, 2020 Eurotech and/or its affiliates and others
#
# All rights reserved. This program and the accompanying materials are made
# available under the terms of the Eclipse Public License 2.0
# which is available at https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#     Eurotech- initial API and implementation
###############################################################################

#
# This script removes the `eclipse-kapua` application from the Openshift.
#
# First it sets the envs to use the `openshift-destroy.sh` in the `kapua-openshift` module.
#
# Then moves into the `kapua-openshift` module root directory and runs `openshift-destroy.sh`.
#

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
OPENSHIFT_SCRIPT_DIR="${SCRIPT_DIR}/../openshift"

(
    pushd ${OPENSHIFT_SCRIPT_DIR}

    eval $(minishift docker-env)
    eval $(minishift oc-env)
    export OPENSHIFT_HOST=$(minishift ip):8443

    ./openshift-destroy.sh

    popd
)
