FILESEXTRAPATHS:prepend := "${THISDIR}:"

inherit daemontools-template

DAEMON_PN = "${PN}-sshd"
DAEMONTOOLS_RUN = "${bindir}/start-sshd.sh"
DAEMONTOOLS_LOG_DIR = "${DAEMONTOOLS_LOG_DIR_PREFIX}/sshd"

SRC_URI += " \
    file://start-sshd.sh \
    file://generate_authorized_keys.sh \
"

do_install:append() {
    install -m 755 ${UNPACKDIR}/start-sshd.sh ${D}${bindir}

    # Note: the script must be added to sshd_config with AuthorizedKeysCommand for
    # the vnctunnel user to permit ip addresses.
    install -d ${D}/${sbindir}
    install -m 0755 ${UNPACKDIR}/generate_authorized_keys.sh ${D}/${sbindir}

    # remove the readonly file, since the normal sshd_config is used.
    rm ${D}${sysconfdir}/ssh/sshd_config_readonly
}

RDEPENDS:${PN} += "bash"

# disable the update-rc.d
INITSCRIPT_PACKAGES = ""
