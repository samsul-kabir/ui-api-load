/*
 * File: app/model/TreeModel.js
 */

Ext.define('TestApp.model.TreeModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'text'
        }
    ]
});