/*
 * File: app/view/LoginWindow.js
 */

Ext.define('TestApp.view.LoginWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.loginWindow',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 135,
    width: 269,
    layout: 'fit',
    title: 'Login',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    bodyPadding: 10,
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: 'User Name',
                            name: 'user',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: 'Password',
                            name: 'password',
                            inputType: 'password',
                            allowBlank: false
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    text: 'Cancel'
                                },
                                {
                                    xtype: 'button',
                                    formBind: true,
                                    text: 'Login',
	                                handler: function(button, e) {
	                                    var form = this.up('form').getForm(),
	                                        authVal = form.getValues(),
	                                        win = this.up('loginWindow');
	                                        enteredUserName = authVal.user;
	                                            if(enteredUserName === credentials.user){
	                                                win.close();
	                                                Ext.create('TestApp.view.Viewport', {});
	                                            }else {
	                                                Ext.Msg.alert('Error', 'Wrong Credentials');
	                                            }
	                                }
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});