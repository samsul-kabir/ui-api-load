/*
 * File: app/view/NorthPanel.js
 */

Ext.define('TestApp.view.NorthPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.northpanel',

    requires: [
        'Ext.form.field.Display'
    ],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            bodyStyle: {
                'background-color': '#cbdbef'
            },
            items: [
                {
                    xtype: 'displayfield',
                    itemId: 'selectedNode',
                    margin: '0 0 0 5',
                    fieldLabel: '<b>Selected Node</b>',
                    labelWidth: 95
                }
            ]
        });

        me.callParent(arguments);
    }

});