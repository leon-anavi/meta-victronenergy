# build but not installed in the image
include qt6-packages.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} += "\
    bc \
    devmem2 \
    gdb \
    dfu-util \
    file \
    gpsd \
    git \
    htop \
    iw \
    kmscube \
    lsof \
    ntp \
    openvpn \
    packagegroup-core-buildessential \
    packagegroup-replace-busybox \
    perf \
    python3-can \
    python3-cbor2 \
    python3-dbus-fast \
    python3-pip \
    python3-pylint \
    python3-spidev \
    qtmqtt \
    s6 \
    start-sway \
    strace \
    tcpdump \
    tinymembench \
    tmux \
    valgrind \
    venus-socketcan-test \
    vim \
    wireguard-tools \
    x11vnc \
"

RDEPENDS:${PN} += " \
    ${QT6_PACKAGES} \
"
