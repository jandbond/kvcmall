
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PurchasePurchaseManager from "./components/listers/PurchasePurchaseCards"
import PurchasePurchaseDetail from "./components/listers/PurchasePurchaseDetail"

import VoucherVoucherManager from "./components/listers/VoucherVoucherCards"
import VoucherVoucherDetail from "./components/listers/VoucherVoucherDetail"

import CustomervoucherCustomerVoucherManager from "./components/listers/CustomervoucherCustomerVoucherCards"
import CustomervoucherCustomerVoucherDetail from "./components/listers/CustomervoucherCustomerVoucherDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"


import CustomerlimitCustomerLimitManager from "./components/listers/CustomerlimitCustomerLimitCards"
import CustomerlimitCustomerLimitDetail from "./components/listers/CustomerlimitCustomerLimitDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/purchases/purchases',
                name: 'PurchasePurchaseManager',
                component: PurchasePurchaseManager
            },
            {
                path: '/purchases/purchases/:id',
                name: 'PurchasePurchaseDetail',
                component: PurchasePurchaseDetail
            },

            {
                path: '/vouchers/vouchers',
                name: 'VoucherVoucherManager',
                component: VoucherVoucherManager
            },
            {
                path: '/vouchers/vouchers/:id',
                name: 'VoucherVoucherDetail',
                component: VoucherVoucherDetail
            },

            {
                path: '/customervouchers/customerVouchers',
                name: 'CustomervoucherCustomerVoucherManager',
                component: CustomervoucherCustomerVoucherManager
            },
            {
                path: '/customervouchers/customerVouchers/:id',
                name: 'CustomervoucherCustomerVoucherDetail',
                component: CustomervoucherCustomerVoucherDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },


            {
                path: '/customerlimits/customerLimits',
                name: 'CustomerlimitCustomerLimitManager',
                component: CustomerlimitCustomerLimitManager
            },
            {
                path: '/customerlimits/customerLimits/:id',
                name: 'CustomerlimitCustomerLimitDetail',
                component: CustomerlimitCustomerLimitDetail
            },



    ]
})
