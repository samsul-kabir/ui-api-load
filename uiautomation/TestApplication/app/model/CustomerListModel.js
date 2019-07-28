/*
 * File: app/model/CustomerListModel.js
 */

Ext.define('TestApp.model.CustomerListModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'title'
        },
        {
            name: 'firstname'
        },
        {
            name: 'lastname'
        },
        {
            name: 'age'
        },
        {
            name: 'manufacturer'
        },
        {
            name: 'hp'
        },
        {
            name: 'comments'
        }
    ]
});