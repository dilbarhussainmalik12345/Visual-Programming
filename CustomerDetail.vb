Public Class CustomerDetail
    Public curr As String = My.Settings.CurrencyS
    Private Sub CustomerDetail_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Call readDataW()
    End Sub
    Sub readDataW()
        ListView1.Columns.Add("CUSTOMER ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("CUSTOMER NAME", 140, HorizontalAlignment.Center)
        ListView1.Columns.Add("CUSTOMER ADDRESS", 140, HorizontalAlignment.Center)
        ListView1.Columns.Add("CONTACT NUMBER", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("SECURITY AMOUNT", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("ACTIVATION DATE", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("VALID TILL", 120, HorizontalAlignment.Center)
        ListView1.View = View.Details
    End Sub
    Sub readData()
        ListView1.Clear()
        ListView1.Columns.Add("CUSTOMER ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("CUSTOMER NAME", 140, HorizontalAlignment.Center)
        ListView1.Columns.Add("CUSTOMER ADDRESS", 140, HorizontalAlignment.Center)
        ListView1.Columns.Add("CONTACT NUMBER", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("SECURITY AMOUNT", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("ACTIVATION DATE", 120, HorizontalAlignment.Center)
        ListView1.Columns.Add("VALID TILL", 120, HorizontalAlignment.Center)
        ListView1.View = View.Details
        Try

            If (objcon.State = ConnectionState.Closed) Then objcon.Open()
            com = New OleDb.OleDbCommand("SELECT * FROM Customer", objcon)
            dr = com.ExecuteReader
            While dr.Read()
                Call adddatatolistview(ListView1, dr(0), dr(1), dr(2), dr(3), dr(4), dr(5), dr(6))
            End While
            dr.Close()
            objcon.Close()
        Catch
            'MsgBox("Please Refresh", MsgBoxStyle.Information, "")
        End Try
    End Sub
    Public Sub adddatatolistview(ByVal lvw As ListView, ByVal CID As String, ByVal CName As String, ByVal CAddress As String, ByVal CCont As String, ByVal Sec As String, ByVal CAct As String, ByVal CVal As String)
        Dim lv As New ListViewItem
        lvw.Items.Add(lv)
        lv.Text = CID
        lv.SubItems.Add(CName)
        lv.SubItems.Add(CAddress)
        lv.SubItems.Add(CCont)
        lv.SubItems.Add(curr + " " + Sec)
        lv.SubItems.Add(CAct)
        lv.SubItems.Add(CVal)
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If TextBox1.Text = "" Then
            Call readData()
        Else
            ListView1.Clear()
            ListView1.Columns.Add("CUSTOMER ID", 90, HorizontalAlignment.Center)
            ListView1.Columns.Add("CUSTOMER NAME", 140, HorizontalAlignment.Center)
            ListView1.Columns.Add("CUSTOMER ADDRESS", 140, HorizontalAlignment.Center)
            ListView1.Columns.Add("CONTACT NUMBER", 120, HorizontalAlignment.Center)
            ListView1.Columns.Add("SECURITY AMOUNT", 120, HorizontalAlignment.Center)
            ListView1.Columns.Add("ACTIVATION DATE", 120, HorizontalAlignment.Center)
            ListView1.Columns.Add("VALID TILL", 120, HorizontalAlignment.Center)
            ListView1.View = View.Details
            Try

                If (objcon.State = ConnectionState.Closed) Then objcon.Open()
                com = New OleDb.OleDbCommand("SELECT * FROM Customer WHERE CID='" & TextBox1.Text & "'", objcon)
                dr = com.ExecuteReader
                While dr.Read()
                    Call adddatatolistview(ListView1, dr(0), dr(1), dr(2), dr(3), dr(4), dr(5), dr(6))
                End While
                dr.Close()
                objcon.Close()
            Catch

            End Try
        End If
    End Sub
    Sub displayThem()

    End Sub

    Private Sub TextBox1_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox1.TextChanged
        Dim i As Integer
        ListView1.SelectedItems.Clear()
        TextBox1.Focus()
        Try
            If Me.TextBox1.Text = "" Then

            Else
                For i = 0 To ListView1.Items.Count - 1
                    If TextBox1.Text = ListView1.Items(i).SubItems(0).Text Then
                        ListView1.Items(i).Selected = True
                        Exit For
                    End If
                Next
            End If
        Catch

        End Try
    End Sub
End Class