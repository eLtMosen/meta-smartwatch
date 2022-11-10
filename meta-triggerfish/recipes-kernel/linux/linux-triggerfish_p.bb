require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Fossil Gen 5 platform"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "triggerfish"

SRC_URI = "git://android.googlesource.com/kernel/msm;branch=android-msm-triggerfish-4.9-pie-wear-mr1;protocol=https \
           file://defconfig \
           file://img_info \
           file://0001-Add-Fossil-device-tree-files.patch \
           file://0002-scripts-dtc-Remove-redundant-YYLOC-global-declaratio.patch \
           "

SRCREV = "82824770e036a1e7576a299bc37b52d633d62675"
LINUX_VERSION ?= "3.18"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
}

inherit mkboot old-kernel-gcc-hdrs
